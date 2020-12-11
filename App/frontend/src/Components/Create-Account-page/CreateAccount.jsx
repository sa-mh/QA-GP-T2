import React, {useState} from 'react'
import axios from 'axios';
import IpContext from '../../IpContext'
import { useContext } from 'react';

const CreateAccount = (props) => {

    const ip = useContext(IpContext);

    // setting the states
    const [firstname, setFirstname] = useState("");
    const [lastname, setLastname] = useState("");
    const [qaEmail, setQaEmail] = useState("");
    const [username, setUsername] = useState("");
    const [cohort, setCohort] = useState("");
    const [member, setMember] = useState("");
    const [password1, setPassword1] = useState("");
    const [password2, setPassword2] = useState("");

    const post_createAccount = (e) => {
        e.preventDefault();
        if(member === "trainee"){
        axios.post("http://"+ip+"/trainee/create", {
            username,
            firstName: firstname,
            secondName: lastname,
            cohort: cohort,
            password: password1,
            traineeEmail: qaEmail
            }    
        ).then(response =>{
            console.log(response);
            props.history.push("/login");
        }).catch(error => {
            console.log(error)
        });
    }else{
        axios.post("http://"+ip+"/trainer/create", {
            username,
            firstName: firstname,
            lastName: lastname,
            password: password1,
            field: cohort,
            trainerEmail: qaEmail
            }    
        ).then(response =>{
            console.log(response);
            props.history.push("/login");
        }).catch(error => {
            console.log(error)
        });
    }}

    const validate = (e) => {
        if (password1 === password2) {
            post_createAccount(e)
        }else{
            alert("Your passwords do not match, please try again");
            e.preventDefault();
        }
    }
    
    return (
        <div>
            <div className="signupDiv">
                <h1 className="signupHeading">Create an account</h1>
                <div>
                    <form className="ml-3" name="pleaseJustWork" id="signupForm" onSubmit={validate}>
                        <input className="signupInput" type="text" id="first-name" onChange={(e)=>setFirstname(e.target.value)} placeholder="Enter your first name" required></input> <br></br>
                        <input className="signupInput" type="text" id="last-name" onChange={(e)=>setLastname(e.target.value)} placeholder="Enter your last name" required></input> <br></br>
                        <input className="signupInput" type="text" id="qa_email" onChange={(e)=>setQaEmail(e.target.value)} placeholder="Enter your QA Email address" required></input> <br></br>
                        <input className="signupInput" type="text" id="username" onChange={(e)=>setUsername(e.target.value)} placeholder="Enter your username" required></input> <br></br>
                        <select defaultValue="" className="signupInput" name="cohort" id="cohort" onChange={e=>setCohort(e.target.value)}>
                            <option value="" disabled hidden>Cohort</option>
                            <option value="Dev Ops">Dev Ops</option>
                            <option value="Cloud Native">Cloud Native</option>
                            <option value="Software Engineer">Software Engineer</option>
                        </select>
                        <select defaultValue="" className="signupInput" name="memberType" id="memberType" onChange={e=>setMember(e.target.value)}>
                            <option value="" disabled hidden>Choose your Member type</option>
                            <option value="trainer">Trainer</option>
                            <option value="trainee">Trainee</option>
                        </select>

                        <input className="signupInput" type="password" id="password1" onChange={(e)=>setPassword1(e.target.value)} placeholder="Enter your password" required></input> <br></br>
                        <input className="signupInput" type="password" id="password2" onChange={(e)=>setPassword2(e.target.value)} placeholder="Re-enter your password" required></input> <br></br>
                        <button className="btn btn-primary" id="signupButton" type="submit">Create an account</button>
                    </form>
                </div>
                <div className="error-message">
                </div>
            </div>
        </div>
    )
}

export default CreateAccount
