import React, {useState, useEffect} from 'react'
import axios from 'axios'
import Issue from '../../Trainer/Issue';
import IpContext from '../../../IpContext'
import { useContext } from 'react';

const PostIssues = ( props ) => {

    const ip = useContext(IpContext);
    const [ticketTitle, setTitle] = useState("");
    const [ticketIssue, setIssue] = useState("");
    const [ticketTopic, setTopic] = useState("");
    const [ticketPriority, setPriority] = useState("");

    //Need to find a way to retrieve the Trainee ID - Likely via prop/state from Login Screen
    const [traineeID] = useState(6)



    const [data, setData] = useState([]);

    useEffect(() => {
        axios.get("http://"+ip+"/ticket/getAll")
            .then(response => {
                response.data.map( (child) => {
                    if(child.status === "new" || child.status === "Open"  ){
                        console.log("I'm here");
                        setData(response.data);
                    }else{
                        console.log("nope");
                    }
                })
            })
    }, [])  

    
    const items = (data.map((issue) =>(
        
        <Issue 
            title={issue.title}
            topic={issue.topic}
            message={issue.issue}
            date={issue.submitDate}
            priority={issue.urgency}
         />
        // <Issue title={issue.title}/>
    )))

    const post_newIssue = (e) => {
        e.preventDefault();
        axios.post("http://"+ip+"/ticket/create", {
            ticketId: 0,
            title: ticketTitle,
	        issue: ticketIssue,
            topic: ticketTopic,
            submitDate: "0000-00-00 00:00:00",
            urgency: ticketPriority,
	        status: "Open",
            traineeId: 1,
            trainerId: 1
            }
        ).then(response =>{
            console.log(response);
            window.location.reload();
        }).catch(error => {
            console.log(error.data)
        });
    }


    return (
        <div>

    {/* Allow user to post an issue here */}
        <div className="createDiv">
            <h3 className="signupHeading">Post an issue</h3>
            <div>
                <form className="ml-3" id="postIssueForm" onSubmit={post_newIssue}>
                    <input className="issueInput" type="text" id="title" onChange={e=>setTitle(e.target.value)} placeholder="Give issue a title" required></input> <br></br>
                    <input className="issueInput" type="text" id="issue" onChange={e=>setIssue(e.target.value)} placeholder="Please explain the issue in as much detail as possible" required></input> <br></br>
                    <select defaultValue="" id="topic" onChange={e=>setTopic(e.target.value)}>
                            <option value="" disabled hidden>Topic</option>
                            <option value="Bug">Bug</option>
                            <option value="React">React</option>
                            <option value="Java">Java</option>
                            <option value="JavaScript">JavaScript</option>
                            <option value="Terraform">Terraform</option>
                            <option value="Ansible">Ansible</option>
                    </select>
                    <select defaultValue="" id="priority"onChange={e=>setPriority(e.target.value)}>
                            <option value="" disabled hidden>Priority</option>
                            <option value="1">High</option>
                            <option value="2">Medium</option>
                            <option value="3">Low</option>
                    </select>
                    <button className="btn btn-primary" id="postButton" type="submit" onSubmit={post_newIssue}>Post Issue</button>
                </form>
            </div>
        </div>

{/* View all the issues currently in the database here */}
<div id="readDiv">
<div className="vl"></div>

    <h5>All the issues currently awaiting help</h5>
{items}

    
</div >
    </div>
    )

}
export default PostIssues;

