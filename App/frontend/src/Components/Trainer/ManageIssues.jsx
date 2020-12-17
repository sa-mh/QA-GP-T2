import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import axios from 'axios'
import TraineeIssue from './TraineeIssue'
import ClosedDataProps from './ClosedDataProps';
import IpContext from '../../IpContext';
import { useContext } from 'react';

const ManageIssues = (props) => {

    const ip = useContext(IpContext);
    const [userDetails, setUserDetails] = useState(props.location.state)
    const [data, setData] = useState([]);
    const [closedData, setClosedData] = useState([])
    const [traineeId, setId] = useState("1");

    console.log(props.location.state); // gets info
    console.log(userDetails);

    useEffect(() => {
        axios.get("http://" + ip + "/ticket/findById?id=" + props.id)
            .then(response => {
                response.data.map((child) => {
                    if (child.status === "new" || child.status === "Open") {
                        console.log("I'm here");
                        setData(response.data);
                    } else {
                        console.log("nope");
                    }
                })
            })
    }, [])

    const items = (data.map((issue) => (
        <TraineeIssue
            title={issue.title}
            topic={issue.topic}
            message={issue.issue}
            date={issue.submitDate}
            priority={issue.urgency}
        />
    )))

    useEffect(() => {
        axios.get("http://" + ip + "/ticket/findById?id=" + props.id)
            .then(response => {
                response.data.map((child) => {
                    if (child.status === "Closed") {
                        setClosedData(response.data);
                    } else {
                        console.log("nope");
                    }
                })
            })
    }, [])



    const ClosedIssues = (closedData.map((issue) => (

        <ClosedDataProps
            title={issue.title}
            topic={issue.topic}
            message={issue.issue}
            date={issue.submitDate}
            priority={issue.urgency}
        />
    )))


    return (

        <>
            <div name="openIssues" id="out_myOpenIssues">
                <h3>Open Issues</h3>
                {items}
            </div>
            <div>
                <Link to="/postIssue">
                    <button id="PostIssueButton">Post a new Issue</button>
                </Link>
            </div>
            <div class="vl"></div>

            <div name="closedIssues" id="out_myClosedIssues">
                <h3 id="completed-heading" >Closed Issues</h3>
                {ClosedIssues}
            </div>
            <div>
                {/* <h2>ISSUE HERE: {props.userDetails}</h2> */}
            </div>
        </>
    );
}
export default ManageIssues;