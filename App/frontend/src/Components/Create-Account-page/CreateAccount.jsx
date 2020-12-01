import React from 'react'


function CreateAccount() {


    return (
        <div>
            <div className="signupDiv">
                <h1 className="signupHeading">Create an account</h1>
                <div>
                    <form className="ml-3" id="signupForm">
                        <input className="signupInput" type="text" id="first-name" placeholder="Enter your first name" required></input> <br></br>
                        <input className="signupInput" type="text" id="last-name" placeholder="Enter your last name" required></input> <br></br>
                        <input className="signupInput" type="text" id="qa_email" placeholder="Enter your QA Email address" required></input> <br></br>
                        <input className="signupInput" type="text" id="username" placeholder="Enter your username" required></input> <br></br>
                        <input className="signupInput" type="password" id="password" placeholder="Enter your password" required></input> <br></br>
                        <input className="signupInput" type="password" id="password" placeholder="Enter your password" required></input> <br></br>
                        <button className="btn btn-primary" id="signupButton" type="submit">Create an account</button>
                    </form>
                </div>
            </div>
        </div>

        
    )
}

export default CreateAccount
