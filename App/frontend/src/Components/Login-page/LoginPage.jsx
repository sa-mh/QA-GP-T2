import React, {useState, Redirect} from 'react'
import { Link } from 'react-router-dom'
import axios from 'axios'
// import { Switch } from 'react-router-dom'
// import CreateAccount from '../Create-Account-page/CreateAccount'
// import { BrowserRouter as Router, Route, } from 'react-router-dom';

function LoginPage() {
    
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [memberType, setMemeberType] = useState("trainee");
    
    const updateUsername = (e) => {
        e.preventDefault(); 
        setUsername(e.target.value);
    }

    const updatePassword = (e) => {
        e.preventDefault(); 
        setPassword(e.target.value);
    }

    const updateMemberType = (e) => {
        setMemeberType(e.target.value);
    }

    const get_Login = (e) => {
        e.preventDefault();
        axios.get("/get/" + memberType + "/" + username)
        .then(response =>{
            console.log(response);
            if(response.data.password === password){
              return  <Redirect  to="../{memberType}"/>;  
            }
            else{
                //Show a login failed message
            }
        }).catch(error => {
            console.log(error.data)
        });
    }


    return (
        <>
            <div className="loginDiv">
                <h1 className="loginHeading">Login</h1>
                <div>
                    <form className="ml-3" id="loginForm">
                        <input className="loginInput" type="text" id="username" placeholder="Enter your username" onChange={(e)=>updateUsername(e)} required></input> <br></br>
                        <input className="loginInput" type="password" id="password" placeholder="Enter your password" onChange={(e)=>updatePassword(e)} required></input> <br></br>
                        <select onChange={(e) => updateMemberType(e)}>
                            <option value="trainer">Trainer</option>
                            <option value="trainee" selected>Trainee</option>
                        </select>
                        <button className="btn btn-primary" id="loginButton" type="submit" onClick={get_Login}>Login</button> 

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
