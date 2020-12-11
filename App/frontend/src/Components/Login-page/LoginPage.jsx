import React, { useState } from 'react'
import { Link } from 'react-router-dom'
import axios from 'axios'
import IpContext from '../../IpContext'
import { useContext } from 'react';

const LoginPage = props => {

    const ip = useContext(IpContext);

    const [data, setData] = useState([]);
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [memberType, setMemberType] = useState("trainee");

    const getLogin = (e) => {
        e.preventDefault();
        axios.get(ip + "/" + memberType + "/findByUsername?Username=" + username)
            .then(response => {
                // console.log(response.data[0].username);
                setData(response.data);
                validate();
            }).catch(error => {
                console.log(error.data)
            });
    }

    let index = 0;
    while (index < data.length) {
        console.log("The username is:" + data[index].username);
        index += 1;
    }

    const validate = () => {

        if (data.username === username && data.password === password) {
            props.history.push("/postIssue");
        }
        else {
            alert("Username/Password is wrong")
        }
    }
    

    return (
        <>
            <div className="loginDiv">
                <h1 className="loginHeading">Login</h1>
                <div>
                    <form className="ml-3" id="loginForm">
                        <input name="username" className="loginInput" type="text" id="username" placeholder="Enter your username" onChange={e => setUsername(e.target.value)} required></input> <br></br>
                        <input name="password" className="loginInput" type="password" id="password" placeholder="Enter your password" onChange={e => setPassword(e.target.value)} required></input> <br></br>
                        <select defaultValue="" name="traineeTrainer" onChange={e => setMemberType(e.target.value)}>
                            <option value="" disabled hidden>Position</option>
                            <option value="Trainer">Trainer</option>
                            <option value="Trainee">Trainee</option>
                        </select>
                        <button className="btn btn-primary" id="loginButton" type="submit" onClick={getLogin}>Login</button>
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


// if(response.data.password === password){
//     props.history.push("/"+memberType);
//   }
//   else{
//       //Show a login failed message
//       const loginError = <p>Username/Password is wrong</p>;
//       ReactDOM.render(loginError, document.getElementById('failed-message'));

//   }