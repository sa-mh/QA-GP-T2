import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import axios from 'axios'
import IpContext from '../../IpContext'
import { useContext } from 'react';
import ReactDOM from 'react-dom';
import PostIssues from '../Trainee/PostIssues/PostIssues';


const LoginPage = props => {

    const ip = useContext(IpContext);

    const [userDetails, setuserDetails] = useState([]);
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [memberType, setMemberType] = useState("");


    const getLogin = (e) => {
        e.preventDefault();
        if (memberType === "trainee") {
            axios.get("http://" + ip + "/trainee/findByUsername/" + username)
                .then(response => {
                    setuserDetails(response.data);
                    console.log(userDetails) //[]
                    // sendToAccount(userDetails);
                    // console.log(response.data.id);
                }).catch(error => {
                    console.log(error)
                });
        } else {
            axios.get("http://" + ip + "/trainer/findByUsername/" + username)
                .then(response => {
                    // console.log(response.data[0].username);
                    setuserDetails(response.data);
                    console.log(userDetails);
                }).catch(error => {
                    console.log(error)
                });
        }
    }


    const validate = (e) => {
        if (userDetails.username === username && userDetails.password === password) {
                props.history.push({pathname: "/postIssue", state: userDetails});
        }
        else {
            e.preventDefault();
            ReactDOM.render(<p style={{ color: "red" }}>Username/Password wrong</p>, document.getElementById('failed-message'));

        }
    }

    return (
        <>
            
            <div className="loginDiv">
                <h1 className="loginHeading">Login</h1>
                <div>
                    <form className="ml-3" id="loginForm" onSubmit={validate}>
                        <input name="username" className="loginInput" type="text" id="username" placeholder="Enter your username" onChange={e => setUsername(e.target.value)} required></input> <br></br>
                        <input name="password" className="loginInput" type="password" id="password" placeholder="Enter your password" onChange={e => setPassword(e.target.value)} required></input> <br></br>
                        <select defaultValue="" name="traineeTrainer" onInput={e => setMemberType(e.target.value)} onChange={getLogin} >
                            <option value="" disabled hidden >Position</option>
                            <option value="trainer">Trainer</option>
                            <option value="trainee">Trainee</option>
                        </select>
                        <button className="btn btn-primary" id="loginButton" type="submit">Login</button>
                        <div>
                            <Link to="/createAccount">
                                <button style={{ backgroundColor: "darkred" }} className="btn btn-primary" id="signUpButton" type="button">Create an account</button>
                            </Link>
                        </div>
                    </form>
                </div>
            </div>

            {/* Login failed will appear here */}
            <div id="failed-message"></div>
        </>
    )
}

export default LoginPage
