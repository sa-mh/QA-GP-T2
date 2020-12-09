import React, {useState, Redirect} from 'react'
import axios from 'axios';
import ReactDOM from 'react-dom'

const CreateAccount = (props) => {

    // setting the states
    const [firstname, setFirstname] = useState("");
    const [lastname, setLastname] = useState("");
    const [qaEmail, setQaEmail] = useState("");
    const [username, setUsername] = useState("");
    const [cohort, setCohort] = useState("");
    const [password1, setPassword1] = useState("");
    const [password2, setPassword2] = useState("");
    const [backendpoint, setBackEndPoint] = useState("http://34.242.81.192:8081");

    const post_createAccount = (e) => {
        e.preventDefault();
        axios.post(backendpoint + "/trainer/create", {
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
    }

    //If password1 and password2 is exactly the same, then setPasswordTheSame as true - If it is false, we need to show an error on the page, if it is true, we can send this to the database.
    const validate = (e) => {
        axios.get("http://34.242.81.192:8081/trainer/getAll")
            .then(response => {
                console.log(response.data);
                let index = 0;
                while (index < response.data.length) {
                    if (response.data[index].username === username){
                      ReactDOM.render(<p>Username already exists, please try again with a different username</p>, document.getElementById('error-message'));
                      e.preventDefault();

                    }
                }
            })
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
