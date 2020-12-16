import React from 'react';

const RespondedIssuesProps =  (props) => {

return (
    <>
        <div className="respond-card">
            <div className="card-body">
                <h5 className="card-title">{props.title}</h5>
                <p className="card-body" id="issue-topic">Topic: {props.topic}</p>
                <p className="card-body" id="issue-message">{props.message}</p>
                <p className="card-body" id="issue-date">Created on: {props.date}</p>
                <p className="card-body" id="completed">Completed</p>
            </div>
        </div>

        

    </>
)
}

export default RespondedIssuesProps;