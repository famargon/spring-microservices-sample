const constants = require('./service.constants');

var express = require('express');
var bodyParser = require('body-parser');

//eureka registration
const eureka = require('./eureka.configuration')();

//zipkin tracing middelware
const {Tracer, ExplicitContext, BatchRecorder} = require('zipkin');
const {HttpLogger} = require('zipkin-transport-http');
const zipkinMiddleware = require('zipkin-instrumentation-express').expressMiddleware;

const ctxImpl = new ExplicitContext();
//const recorder = new ConsoleRecorder();
const recorder = new BatchRecorder({
  logger: new HttpLogger({
    endpoint: 'http://localhost:9411/api/v1/spans'
  })
});
const localServiceName = constants.SERVICE_NAME; // name of this application
const tracer = new Tracer({ctxImpl, recorder, localServiceName});

var app = express();

app.use(bodyParser.urlencoded({extended: false}));
app.use(bodyParser.json());

app.use(zipkinMiddleware({tracer}));

app.all('/status', function (req, res) {
    console.log("status request received")
    res.status(200);
    res.end();
});

app.get("/substract/:a/:b",function(req,res){
    console.log("received substract request")
    res.status(200);   
    res.setHeader("Content-Type","application/json")
    res.end(JSON.stringify({result:req.params.a-req.params.b,port:constants.SERVER_PORT,serviceData:"hello from node microservice!"}))
});

app.listen(constants.SERVER_PORT, function () {
  console.log('Listening at port: '+ constants.SERVER_PORT);
});