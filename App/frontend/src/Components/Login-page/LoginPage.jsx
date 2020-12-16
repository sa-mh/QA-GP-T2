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
    const [trainerDetails, setTrainerDetails] = useState([]);


    const getLogin = (e) => {
        e.preventDefault();
        if (memberType === "trainee") {
            axios.get("http://" + ip + "/trainee/findByUsername/" + username)
                .then(response => {
                    setuserDetails(response.data);
                    console.log(userDetails)
                }).catch(error => {
                    console.log(error)
                });
        } else {
            axios.get("http://" + ip + "/trainer/getAll")
                .then(response => {
                    // console.log(response.data);
                    setTrainerDetails(response.data);
                }).catch(error => {
                    console.log(error)
                });
        }
    }
    console.log(trainerDetails);
    const validate = (e) => {
        if (userDetails.username === username && userDetails.password === password) {
            props.history.push({ pathname: "/postIssue", state: userDetails });
        }
        else if (memberType === "trainer") {
            e.preventDefault();
            validateTrainer();
        }
        else {
            e.preventDefault();
            ReactDOM.render(<p style={{ color: "red"}}>Username/Password wrong. Please try again.</p>, document.getElementById('failed-message'));

        }
    }

    const validateTrainer = (e) => {

        let index = 0;
        while (index < trainerDetails.length) {
            console.log("the value of index is :" + {index})
            if (trainerDetails[index].username === username && trainerDetails[index].password === password) {
            //    window.location.reload(false);    
                props.history.push({ pathname: "/viewAllIssues", state: trainerDetails });
                console.log("it works");
            }
            else {
                ReactDOM.render(<p style={{ color: "red" }}>Username/Password wrong</p>, document.getElementById('failed-message'));

            }
            index += 1;
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
                        </select><br></br>
                        <button className="btn btn-primary" id="loginButton" type="submit">Login</button>
                        <p>Dont have an account? You can create one using the button below</p>
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
