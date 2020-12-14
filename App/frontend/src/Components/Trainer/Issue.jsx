import React from 'react';

const Issue = (props) => {

    return (
        <>
            <div className="card">
                <div className="card-body">
                    <h5 className="card-title">{props.title}</h5>
                    <p className="card-body" id="issue-topic">Topic: {props.topic}</p>
                    <p className="card-body">{props.message}</p>
                    <p className="card-body" id="issue-date">Created on: {props.date}</p>
                    <p className="card-body" id="issue-priority">Priority: {props.priority}</p>
                    <button className="card-body" id="solve-button">Solve</button>
                </div>
            </div>
        </>
    )
}

export default Issue;