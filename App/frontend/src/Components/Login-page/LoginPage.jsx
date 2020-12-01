import React from 'react'

function LoginPage() {
    return (
        <>
            <div className="loginDiv">
                <h1 className="loginHeading">Login</h1>
                <div>
                    <form className="ml-3" id="loginForm">
                        <input className="loginInput" type="text" id="username" placeholder="Enter your username" required></input> <br></br>
                        <input className="loginInput" type="password" id="password" placeholder="Enter your password" required></input> <br></br>
                        <button class="btn btn-primary" id="loginButton" type="submit">Login</button>
                    </form>
                </div>
            </div>
        </>
    )
}

export default LoginPage
