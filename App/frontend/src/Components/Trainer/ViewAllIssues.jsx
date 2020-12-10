import React, { useEffect, useState } from 'react'
import axios from 'axios'
import Issue from './Issue';
import RespondedIssuesProps from './RespondedIssuesProps';


const ViewAllIssues = () => {

    const [data, setData] = useState([]);
    const [traineeId, setTraineeId] = useState("");
    const [respondedData, setRespondedData] = useState([]);

    useEffect(() => {
        axios.get("http://52.48.80.243:8081/ticket/getAll")
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


    const items = (data.map((issue) => (
        
        <Issue
            title={issue.title}
            topic={issue.topic}
            message={issue.issue}
            date={issue.submitDate}
            priority={issue.urgency}
        />
    )))


    useEffect(() => {
        axios.get("http://52.48.80.243:8081/ticket/getAll")
            .then(response => {
                response.data.map( (child) => {
                    if(child.status === "Closed" ){
                        console.log("I'm here");
                        setRespondedData(response.data);
                    }else{
                        console.log("nope");
                    }
                })
            })
    }, [])  



    const Respondeditems = (respondedData.map((issue) => (
        
        <RespondedIssuesProps
            title={issue.title}
            topic={issue.topic}
            message={issue.issue}
            date={issue.submitDate}
            priority={issue.urgency}
        />
    )))



    return (
        <>
            <h3> View all the Issues here</h3>
            <div name="issues" id="issues">
                {items}
            </div>

            <div class="vl"></div>

            <h3 id="completed-heading">Completed Items</h3>
            <div name="issues" id="completed">
                {Respondeditems}
            </div>
        </>
    );

};
export default ViewAllIssues;