const express=require('express');
const routes=require('./routes/getDataRoute');
const bodyParser = require("body-parser");
const cors = require('cors')

const app=express();
const corsOptions ={
    origin:'http://localhost:3000', 
    credentials:true,            //access-control-allow-credentials:true
    optionSuccessStatus:200
}
app.use(cors(corsOptions));
app.options('*',cors())
app.use(bodyParser.json())
app.use('/',routes)

app.listen(4000,()=>{
    console.log('Listening on PORT 4000');
})