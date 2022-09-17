const { query } = require('express');
const express=require('express');
const router=express.Router();
const mysql = require('mysql');

router.get('/',(req,res)=>{
    console.log('get call');
    return res.status(200).send({name:'soh'})
});

router.post('/insert',(req,res)=>{
    console.log('req.body',req.body);
    const score=req.body.score;
    const username=req.body.username;

    const connection = mysql.createConnection({
        host: '172.31.82.135',
        user: 'root',
        password: 'Ecofriend38',
        database: 'ecofriend'
    });
    
    connection.connect(function(err) {
        if (err) {
          return console.error('error: ' + err.message);
        }
      
        console.log('Connected to the MySQL server.');
      });
      const query='INSERT INTO reactQuiz(score,username) VALUES("'+score+'","'+username+'")'
      connection.query(query,(err,fields,result)=>{
          if(err) console.log('err',err);
          console.log(fields,result);
      });
    return res.status(200).send({name:'Inserted Data'})
});

module.exports= router;