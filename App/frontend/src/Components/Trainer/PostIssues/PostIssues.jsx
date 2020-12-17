import React, { useState, useEffect } from 'react'
import axios from 'axios'
import Issue from '../../Trainer/Issue';
import IpContext from '../../../IpContext'
import { useContext } from 'react';
import { Link } from 'react-router-dom'
import ManageIssues from '../ManageIssues';
import SearchableIssues from "./SearchableIssues";


const PostIssues = props => {

    const ip = useContext(IpContext);
    const [ticketTitle, setTitle] = useState("");
    const [ticketIssue, setIssue] = useState("");
    const [ticketTopic, setTopic] = useState("");
    const [ticketPriority, setPriority] = useState("");
    const [author, setAuthor] = useState("Anonymous");
    const [userDetails, setuserDetails] = useState(props.location.state);
    const [search, setSearch] = useState("");
    const [data, setData] = useState([]);



    const post_newIssue = (e) => {
        e.preventDefault();
        axios.post("/api/ticket/create", {
            title: ticketTitle,
            issue: ticketIssue,
            topic: ticketTopic,
            submitDate: null,
            urgency: ticketPriority,
            status: "Open",
            author: author
        })
            .then(response => {
                debugger
                console.log(response.data);
                window.location.reload();
            }).catch(error => {
                debuggers
                console.log(error)
            });
    }


    const sendProps =() => {
        props.history.push({pathname: "/viewAllIssues", state: userDetails});
    }

    return (
        <div>

            {/* Allow user to post an issue here */}
            <div className="createDiv">
                <h3 className="createPost-heading">Post an issue</h3>
                <div>
                    <form className="ml-3" id="postIssueForm" onSubmit={post_newIssue}>
                    <input className="issueInput" type="text" id="author" onChange={e => setAuthor(e.target.value)} placeholder="Enter your full name"></input> <br></br>
                        <input className="issueInput" type="text" id="title" onChange={e => setTitle(e.target.value)} placeholder="Give issue a title" required></input> <br></br>
                        <input className="issueInput" type="text" id="issue" onChange={e => setIssue(e.target.value)} placeholder="Please explain the issue in as much detail as possible" required></input> <br></br>
                        <select defaultValue="" id="topic" onChange={e => setTopic(e.target.value)}>
                            <option value="" disabled hidden>Topic</option>
                            <option value="Bug">Bug</option>
                            <option value="React">React</option>
                            <option value="Java">Java</option>
                            <option value="JavaScript">JavaScript</option>
                            <option value="Terraform">Terraform</option>
                            <option value="Python">Python</option>
                            <option value="AWS">AWS</option>
                            <option value="Ansible">Ansible</option>
                            <option value="Linux">Linux</option>
                        </select>
                        <select defaultValue="" id="priority" onChange={e => setPriority(e.target.value)}>
                            <option value="" disabled hidden>Priority</option>
                            <option value="5">Very High</option>
                            <option value="4">High</option>
                            <option value="3">Medium</option>
                            <option value="2">Low</option>
                            <option value="1">Very Low</option>
                        </select>
                        <button className="btn btn-primary" id="postButton" type="submit" onSubmit={post_newIssue}>Post Issue</button>
                    </form>
                    <p id="post-note">*Please note that all tickets posted will be responded to by a trainer as soon as possible. You will be notified via email when a response has been made.</p>
                </div>
            </div>
            <div>

                    <button id="ManageIssueButton" onClick={sendProps}>View Closed Issues</button>
            </div>

            {/* View all the issues currently in the database here */}
            <div id="readDiv">
                <SearchableIssues />
            </div >
        </div>
    )

}
export default PostIssues;

