import React, { useState, useEffect } from 'react'
import axios from 'axios'
import Issue from '../Issue';
import Search from './Search';

const SearchableIssues = () => {

    const [data, setData] = useState([]);





    useEffect(() => {
        axios.get("http://" + "localhost:8081" + "/ticket/findByStatus/Open")
            .then(response => {
                response.data.map((child) => {
                    setData(response.data);
                })
            })
    }, [])

    const searchIssues = (e) => {
        axios.get("http://" + "localhost:8081" + "/ticket/findByTopic/" + e)
            .then(response => {
                response.data.map((child) => {
                    console.log(child);
                    setData(response.data);
                    console.log(data)

                })
            })
    }

    const searchAuthor = (e) => {
        axios.get("http://" + "localhost:8081" + "/ticket/findByAuthor/" + e)
            .then(response => {
                response.data.map((child) => {
                    console.log(child);
                    setData(response.data);
                    console.log(data)

                })
            })
    }

    const items = (data.map((issue) => (
        <Issue
            ticketId={issue.id}
            title={issue.title}
            topic={issue.topic}
            message={issue.issue}
            date={issue.submitDate}
            priority={issue.urgency}
            author={issue.author}
        />
        // <Issue title={issue.title}/>
    )))
    return (
        <>

            {/* <Search query={query} updateState={updateQuery} updateCheck={updateCheck} /> */}
            <div id="readDiv">
                <div id="filter"><label>Filter by topic: </label>
                    <select defaultValue="" id="topic" onChange={e => searchIssues(e.target.value)}>
                        <option value="" disabled>Topic</option>
                        <option value="Bug">Bug</option>
                        <option value="React">React</option>
                        <option value="Java">Java</option>
                        <option value="JavaScript">JavaScript</option>
                        <option value="Terraform">Terraform</option>
                        <option value="Ansible">Ansible</option>
                    </select></div>
                <div id="author-filter"><label>Filter by Author: </label>
                    <input type="text" id="author-filter" onChange={e =>searchAuthor(e.target.value)} placeholder="Search by an author" ></input> <br></br>
                </div>
                <h5 id="readDiv-heading">All the issues currently awaiting help</h5>
                <div className="vl"></div>
                {items}
            </div >
        </>
    )


}

export default SearchableIssues;