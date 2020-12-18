import React from 'react';
import axios from 'axios'



const RespondedIssuesProps =  (props) => {

    const deleteTicket = () => {
        axios.delete("/api/ticket/remove/" + props.ticketId, {
            headers: {
                'Access-Control-Allow-Origin' : '*',     
                'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH'   
            }
        }).then(response => {
            console.log(response);
            window.location.reload();
        }).catch(error => {
            console.log(error.data)
        });
    }

return (
    <>
        <div className="respond-card">
            <div className="card-body">
                <h5 className="card-title">{props.title} - {props.author}</h5>
                <p className="card-body" id="issue-topic">Topic: {props.topic}</p>
                <p className="card-body" id="issue-message">{props.message}</p>
                <p className="card-body" id="issue-date">Created on: {props.date}</p>
                <p className="card-body" id="completed">Completed</p>
                <br></br>
                <p className="card-body" id="solution">Solution: {props.solution}</p>
                <button className="card-body" id="remove-button" onClick={deleteTicket}>Remove</button>
            </div>
        </div>

        

    </>
)
}

export default RespondedIssuesProps;