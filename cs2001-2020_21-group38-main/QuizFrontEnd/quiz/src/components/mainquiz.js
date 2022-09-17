// mainquiz.js main functionality of quiz
import React, { Component } from "react";
import { Link } from "react-router-dom";
import Question from "./Question";
import Answer from "./Answer";
import "./mainquiz.css";

export default class Quiz extends Component {

//questions
  state = {
    questions: {
      1: "How many schools don't have clean water?",
      2: "How many healthcare facilities lack basic water services?",
      3: "How many people do not have access to clean water near their home?",
      4: "What percentage of the world's water is fresh (drinkable)?",
      5: "How many people do not have access to clean water near their home?",
    },
    answers: {
      1: {
        1: "31%",
        2: "32%",
        3: "40%",
      },
      2: {
        1: "1 in 3",
        2: "1 in 4",
        3: "2 in 5",
      },
      3: {
        1: "525 million",
        2: "685 million",
        3: "785 million",
      },
      4: {
        1: "2.5%",
        2: "3%",
        3: "10%",
      },
      5: {
        1: "785 million",
        2: "842 million",
        3: "985 million",
      },
    },

//state with the correct answers
    correctAnswers: {
      1: "1",
      2: "2",
      3: "3",
      4: "2",
      5: "1",
    },
    correctAnswer: 0,
    clickedAnswer: 0,
    step: 1,
    score: 0,
  };
  constructor(props) {
    super(props);
    console.log(props?.location?.query?.username, "props");
  }

  // checks the correct answer
  checkAnswer = (answer) => {
    const { correctAnswers, step, score } = this.state;
    if (answer === correctAnswers[step]) {
      this.setState({
        score: score + 1,
        correctAnswer: correctAnswers[step],
        clickedAnswer: answer,
      });
    } else {
      this.setState({
        correctAnswer: 0,
        clickedAnswer: answer,
      });
    }
  };

  // method to move to the next question
  nextStep = (step) => {
    this.setState({
      step: step + 1,
      correctAnswer: 0,
      clickedAnswer: 0,
    });
  };

  render() {
    let {
      questions,
      answers,
      correctAnswer,
      clickedAnswer,
      step,
      score,
    } = this.state;
    return (
      <div className="qPage">
        <h3>{this.props?.location?.query?.username}</h3>
        {step <= Object.keys(questions).length ? (
          <>
            <Question question={questions[step]} />
            <Answer
              answer={answers[step]}
              step={step}
              checkAnswer={this.checkAnswer}
            />
            <button
              className="NextStep"
              disabled={
                clickedAnswer && Object.keys(questions).length >= step
                  ? false
                  : true
              }
              onClick={() => this.nextStep(step)}
            >
              Next
            </button>
          </>
        ) : (
          <div className="finalPage">
            <h1>You have completed the quiz!</h1>
            <Link
              to={{
                pathname: `/score`,
                query: { username:this.props?.location?.query?.username,
                    score:score },
              }}
            >
              View Leaderboard
            </Link>

          </div>
        )}
      </div>
    );
  }
}
