import React, { useState } from "react"
import {Link} from 'react-router-dom'
import Quiz from './mainquiz'
import axios from 'axios';

const QuizHome = () => {
    const [name,setName]=useState('')
    return ( 
        <div>
            EcoFriend Quiz<br/>
            <label>Username</label>
            <input placeholder='Enter username' onChange={(e)=>setName(e.target.value)} required></input>
            <br/><Link  to={{
                pathname: `/quiz`, 
                query:{username: name}
              }}>Take Quiz</Link>
        </div>
     );
}
 
export default QuizHome;

