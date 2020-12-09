import React, { useState } from 'react'
import { Link } from 'react-router-dom'
import axios from 'axios'
import ReactDOM from 'react'
import { browserHistory } from 'react-router-dom';

// import { Switch } from 'react-router-dom'
// import CreateAccount from '../Create-Account-page/CreateAccount'
// import { BrowserRouter as Router, Route, } from 'react-router-dom';

const LoginPage = props => {

    const [data, setData] = useState([]);
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [memberType, setMemberType] = useState("Trainee");
    const [backendpoint, setBackEndPoint] = useState("http://34.242.81.192:8081");

    const getLogin = (e) => {
        e.preventDefault();
        axios.get(backendpoint + "/" + memberType + "/findByUsername?Username=" + username)
            .then(response => {
                // console.log(response.data[0].username);
                setData(response.data);
                validate();
            }).catch(error => {
                console.log(error.data)
            });
    }

<<<<<<< HEAD
    let index = 0;
    while (index < data.length) {
        console.log("The username is:" + data[index].username);
        index += 1;
=======
            }
        }).catch(error => {
            console.log(error.data)
            const loginError = <p>Username/Password is wrong</p>;
            ReactDOM.render(loginError, document.getElementById('failed-message'));
        });
>>>>>>> 44a0d823f7762d43bd73c3fa578fcf7b6dc431c9
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
<<<<<<< HEAD
                    <form className="ml-3" id="loginForm">
                        <input name="username" className="loginInput" type="text" id="username" placeholder="Enter your username" onChange={e => setUsername(e.target.value)} required></input> <br></br>
                        <input name="password" className="loginInput" type="password" id="password" placeholder="Enter your password" onChange={e => setPassword(e.target.value)} required></input> <br></br>
                        <select name="traineeTrainer" onChange={e => setMemberType(e.target.value)}>
=======
                    <form className="ml-3" id="loginForm" onSubmit={get_Login}>
                        <input name="username" className="loginInput" type="text" id="username" placeholder="Enter your username" onChange={e=>setUsername(e.target.value)} required></input> <br></br>
                        <input name="password" className="loginInput" type="password" id="password" placeholder="Enter your password" onChange={e=>setPassword(e.target.value)} required></input> <br></br>
                        <select name="traineeTrainer" onChange={e=>setMemberType(e.target.value)}>
>>>>>>> 44a0d823f7762d43bd73c3fa578fcf7b6dc431c9
                            <option value="" selected disabled hidden>Position</option>
                            <option value="trainer">Trainer</option>
                            <option value="trainee" selected>Trainee</option>
                        </select>
<<<<<<< HEAD
                        <button className="btn btn-primary" id="loginButton" type="submit" onClick={getLogin}>Login</button>
=======
                        <button className="btn btn-primary" id="loginButton" type="submit">Login</button>
>>>>>>> 44a0d823f7762d43bd73c3fa578fcf7b6dc431c9
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