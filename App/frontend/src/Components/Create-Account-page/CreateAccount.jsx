import React, {useState} from 'react'


const CreateAccount = () => {

    // setting the states
    const [firstname, setFirstname] = useState("");
    const [lastname, setLastname] = useState("");
    const [qaEmail, setQaEmail] = useState("");
    const [username, setUsername] = useState("");
    const [password1, setPassword1] = useState("");
    const [password2, setPassword2] = useState("");
    const [passwordTheSame, setPasswordTheSame] = useState(false);

    //Update all the values as they are changed in the input fields
    const updateFirstName = (e) => {
        e.preventDefault(); 
        setFirstname(e.target.value);
    }

    const updateLastName = (e) => {
        e.preventDefault(); 
        setLastname(e.target.value);
    }

    const updateEmail = (e) => {
        e.preventDefault(); 
        setQaEmail(e.target.value);
    }
    
    const updateUsername = (e) => {
        e.preventDefault(); 
        setUsername(e.target.value);
    }

    const updatePassword1 = (e) => {
        e.preventDefault(); 
        setPassword1(e.target.value);
    }

    const updatePassword2 = (e) => {
        e.preventDefault(); 
        setPassword2(e.target.value);
        isPasswordSame(password1,password2);
    }

    //If password1 and password2 is exactly the same, then setPasswordTheSame as true - If it is false, we need to show an error on the page, if it is true, we can send this to the database.
    const isPasswordSame = (password1, password2) => {
        if (password1 === password2) {
            setPasswordTheSame(true)
        }
    }
    

    return (
        <div>
            <div className="signupDiv">
                <h1 className="signupHeading">Create an account</h1>
                <div>
                    <form className="ml-3" id="signupForm">
                        <input className="signupInput" type="text" id="first-name" onChange={(e)=>updateFirstName(e)} placeholder="Enter your first name" required></input> <br></br>
                        <input className="signupInput" type="text" id="last-name" onChange={(e)=>updateLastName(e)} placeholder="Enter your last name" required></input> <br></br>
                        <input className="signupInput" type="text" id="qa_email" onChange={(e)=>updateEmail(e)} placeholder="Enter your QA Email address" required></input> <br></br>
                        <input className="signupInput" type="text" id="username" onChange={(e)=>updateUsername(e)} placeholder="Enter your username" required></input> <br></br>
                        <input className="signupInput" type="password" id="password" onChange={(e)=>updatePassword1(e)} placeholder="Enter your password" required></input> <br></br>
                        <input className="signupInput" type="password" id="password" onChange={(e)=>updatePassword2(e)} placeholder="Enter your password" required></input> <br></br>
                        <button className="btn btn-primary" id="signupButton" type="submit">Create an account</button>
                    </form>
                </div>
            </div>
        </div>

        
    )
}

export default CreateAccount
