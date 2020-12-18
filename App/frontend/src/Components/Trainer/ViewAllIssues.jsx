import React, { useEffect, useState} from 'react'
import axios from 'axios'
import Issue from './Issue';
import RespondedIssuesProps from './RespondedIssuesProps';
import ReactDOM from 'react-dom';
import { Link } from 'react-router-dom'


const ViewAllIssues = () => {

    const [data, setData] = useState([]);
    const [respondedData, setRespondedData] = useState([]);

    
    
    useEffect(() => {
        axios.get("/api/ticket/findByStatus/Closed")
            .then(response => {
                response.data.map( (child) => {
                    if(child.status === "Closed" ){
                        console.log("I'm here");
                        setRespondedData(response.data);
                    }else{
                    }
                })
            })
    }, [])  



    const Respondeditems = (respondedData.map((issue) => (
        
        <RespondedIssuesProps
            ticketId={issue.id}
            author={issue.author}
            title={issue.title}
            topic={issue.topic}
            message={issue.issue}
            date={issue.submitDate}
            priority={issue.urgency}
            solution={issue.solution}
        />
    )))

    return (
        <>
            

            <h3 id="completed-heading">Completed Items</h3>
            <div name="issues" id="completed-issues">
        <p id="completed-p"> Below shows all the items that has been responded to by the trainers.</p>
                {Respondeditems}
            </div>
        
            <Link to="/postIssue" ><button id="ManageIssueButton">Back To Issues</button></Link>
        </>
    );

};
export default ViewAllIssues;