import React, { useEffect, useState } from 'react'
import axios from 'axios'
import Issue from './Issue';


const ViewAllIssues = () => {

    const [data, setData] = useState([]);
    const [backendpoint, setBackEndPoint] = useState("http://localhost:8081");

    const allIssues = document.getElementById("issues");


    useEffect(() => {
        axios.get("http://localhost:8081/ticket/getAll")
            .then(response => {
                console.log(response.data);
                setData(response.data);
            })
    }, [])


    let index = 0;
    while (index < data.length) {
        console.log(data[index].issue);
        console.log(data[index].status);
        console.log(data[index].submitDate);
        console.log(data[index].title);
        console.log(data[index].topic);
        console.log(data[index].urgency);
        index += 1;
    }
    const items = (data.map((issue) =>(
        
        <Issue 
            title={issue.title}
            topic={issue.topic}
            message={issue.issue}
            date={issue.submitDate}
            priority={issue.urgency}
         />
        // <Issue title={issue.title}/>
    )))
    //The data saved from the API call should be then used to display it on the page.  
    return (
        <>
            <h1> View all the Issues here</h1>

            <div name="issues" id="issues">
               {items}
            </div>

            <div class="vl"></div>

        </>
    );

};
export default ViewAllIssues;