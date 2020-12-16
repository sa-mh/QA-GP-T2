import React, { useEffect, useState, useContext } from 'react'
import axios from 'axios'
import Issue from './Issue';
import RespondedIssuesProps from './RespondedIssuesProps';
import IpContext from '../../IpContext';


const ViewAllIssues = () => {

    const ip = useContext(IpContext);
    const [data, setData] = useState([]);
    const [respondedData, setRespondedData] = useState([]);

    useEffect(() => {
        axios.get("http://"+ip+"/ticket/findByStatus/Open")
            .then(response => {
                response.data.map( (child) => {
                    if(child.status === "Open"  ){
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
            ticketId={issue.id}
            title={issue.title}
            topic={issue.topic}
            message={issue.issue}
            date={issue.submitDate}
            priority={issue.urgency}
        />
    )))


    useEffect(() => {
        axios.get("http://"+ip+"/ticket/findByStatus/Closed")
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
            ticketId={issue.id}
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


            <h3 id="completed-heading">Completed Items</h3>
            <div name="issues" id="completed-issues">
            <div className="vl"></div>

                {Respondeditems}
            </div>
        </>
    );

};
export default ViewAllIssues;