import React from 'react'

function LoginDiv() {
    return (
        <div className="loginDiv">
            <h1 className="loginHeading">Login</h1>
            <div>
            <form className="ml-3" id="loginForm">
                <input type="text" id="username" placeholder="Enter your username" required></input>
                <input type="password" id="password" placeholder="Enter your password" required></input>
                <button class="btn btn-primary" id ="loginButton" type="submit">Login</button>
       </form>
        </div>
    );
}

export default LoginDiv
