import React from 'react'
import { Link } from 'react-router-dom'
// import { Switch } from 'react-router-dom'
// import CreateAccount from '../Create-Account-page/CreateAccount'
// import { BrowserRouter as Router, Route, } from 'react-router-dom';

function LoginPage() {
    return (
        <>
            <div className="loginDiv">
                <h1 className="loginHeading">Login</h1>
                <div>
                    <form className="ml-3" id="loginForm">
                        <input className="loginInput" type="text" id="username" placeholder="Enter your username" required></input> <br></br>
                        <input className="loginInput" type="password" id="password" placeholder="Enter your password" required></input> <br></br>
                        <Link to="/postIssue">
                        <button className="btn btn-primary" id="loginButton" type="submit">Login</button> 
                        </Link>
                        <div>
                            <Link to="/createAccount">
                                <button style={{ backgroundColor: "darkred" }} className="btn btn-primary" id="signUpButton" type="button">Create an account</button>
                            </Link>
                        </div>
                    </form>
                </div>
            </div>
        </>
    )
}

export default LoginPage
