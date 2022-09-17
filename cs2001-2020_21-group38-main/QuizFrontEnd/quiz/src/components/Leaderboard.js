import React from 'react';
import './Leaderboard.css';
import {Link} from 'react-router-dom'
import axios from 'axios';

const Leaderboard = (props) => {
    console.log('score',props);
    const insertRecord=()=>{
        const config = {
            headers: {
              "Access-Control-Allow-Origin": "*",
              "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS"
            }
          };

        axios.post('http://localhost:4000/insert',{username:props?.location?.query?.username,score:props?.location?.query?.score},config).then(result=>{
            console.log('result is',result);
        }).catch(error=>console.log('error',error));
    }
    return ( 
        <div className="Leaderboard">
            Username: {props?.location?.query?.username}<br/>
            Score: {props?.location?.query?.score}
            <br/><Link  to='/home'>Retry Quiz</Link>
            <button onClick={insertRecord}>Submit Score</button>
        </div>
     );
}
 
export default Leaderboard;