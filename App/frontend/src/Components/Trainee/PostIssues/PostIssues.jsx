import React, {useState} from 'react'
import axios from 'axios'

const PostIssues = () => {

    const [ticketTitle, setTitle] = useState("");
    const [ticketIssue, setIssue] = useState("");
    const [ticketTopic, setTopic] = useState("");
    const [ticketPriority, setPriority] = useState("");
    const [backendpoint, setBackEndPoint] = useState("http://localhost:8081");

    //Need to find a way to retrieve the Trainee ID - Likely via prop/state from Login Screen
    const [traineeID] = useState(6)

    const post_newIssue = (e) => {
        e.preventDefault();
        axios.post(backendpoint+"/ticket/create", {
            title: ticketTitle,
	        issue: ticketIssue,
	        topic: ticketTopic,
            urgency: ticketPriority,
	        status: "Open",
	        traineeID: traineeID,
            }
        ).then(response =>{
            console.log(response);
            // window.location.reload();
        }).catch(error => {
            console.log(error.data)
        });
    }


    return (
        <div>
        <div className="createDiv">
            <h1 className="signupHeading">Post an issue</h1>
            <div>
                <form className="ml-3" id="postIssueForm" onSubmit={post_newIssue}>
                    <input className="issueInput" type="text" id="Title" onChange={e=>setTitle(e.target.value)} placeholder="Give issue a title" required></input> <br></br>
                    <input className="issueInput" type="text" id="Issue" onChange={e=>setIssue(e.target.value)} placeholder="Please explain the issue in as much detail as possible" required></input> <br></br>
                    <select defaultValue="" id="Topic" onChange={e=>setTopic(e.target.value)}>
                            <option value="" disabled hidden>Cohort</option>
                            <option value="Bug">Bug</option>
                            <option value="React">React</option>
                            <option value="Java">Java</option>
                            <option value="JavaScript">JavaScript</option>
                            <option value="Terraform">Terraform</option>
                            <option value="Ansible">Ansible</option>
                    </select>
                    <select defaultValue="" id="Priority"onChange={e=>setPriority(e.target.value)}>
                            <option value="" disabled hidden>Cohort</option>
                            <option value="1">High</option>
                            <option value="2">Medium</option>
                            <option value="3">Low</option>
                    </select>
                    <button className="btn btn-primary" id="postButton" type="submit">Post Issue</button>
                </form>
            </div>
        </div>
    </div>
    )

}
export default PostIssues;

