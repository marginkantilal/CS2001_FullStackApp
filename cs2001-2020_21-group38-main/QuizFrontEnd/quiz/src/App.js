import React from 'react';
import {BrowserRouter as Router, Switch,Route} from 'react-router-dom'
import './App.css';
import Quiz from './components/mainquiz';
import Home from './components/quizHome';
import Leaderboard from './components/Leaderboard';


function App() {
  return (
    <Router>
      <Switch>
      <Route exact path='/' component={Home}/>
        <Route exact path='/home' component={Home}/>
        <Route exact path='/quiz' component={Quiz}/>
        <Route exact path='/score' component={Leaderboard}/>
      </Switch>
    </Router>
  );
}

export default App;
