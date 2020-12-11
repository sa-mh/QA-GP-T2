import React from 'react'
import axios from 'axios'

const Issue = (props) => {


    const closeTicket = (e) => {
        e.preventDefault();
        axios.put("http://54.194.254.129:8081/ticket/update", {
            ticketId: props.ticketId,
            title: props.title,
            issue: props.message,
            topic: props.topic,
            submitDate: props.date,
            urgency: props.priority,
            status: "Closed",
            traineeId: 1,
            trainerId: 1
        }).then(response => {
            console.log(response);
            // window.location.reload();
        }).catch(error => {
            console.log(error.data)
        });
    }


    return (
        <>
            <div className="card">
                <div className="card-body">
                    <h5 className="card-title">{props.title}</h5>
                    <p className="card-body" id="issue-topic">Topic: {props.topic}</p>
                    <p className="card-body">{props.message}</p>
                    <p className="card-body" id="issue-date">Created on: {props.date}</p>
                    <p className="card-body" id="issue-priority">Priority: {props.priority}</p>
                    <button className="card-body" id="solve-button" onClick={closeTicket}>Done</button>
                </div>
            </div>

        </>
    )
}

export default Issue;