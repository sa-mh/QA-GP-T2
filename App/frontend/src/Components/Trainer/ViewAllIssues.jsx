import React, { useState } from 'react'
import axios from 'axios'
import Issue from './Issue';


const ViewAllIssues = () => {

    const [data, setData] = useState("");
    const [backendpoint, setBackEndPoint] = useState("http://localhost:8081");

    const allIssues = document.getElementsByClassName("card");



    // making a get request which pulls the issues from the database - NOT SURE IF THIS WORKS. please Fix!
    axios.get(backendpoint + "/trainer/getAll")
        .then(response => {
            console.log(response.data);
            setData(response.data);
        }).then(data.forEach(function(issue){
                allIssues.appendChild(
            <Issue props={
                issue.title, 
                issue.topic, 
                issue.message, 
                issue.date, 
                issue.priority
            }/>);

        }));



    //The data saved from the API call should be then used to display it on the page.  
    return (
        <>
        <h1> View all the Issues here</h1>

        {/* <Issue 
        title={"The title of the issue appears here"} 
        message={"Get Axios to pull and display data"}
        topic={"Chosen topic"}
        date={"01/02/03"}
        priority={"High"}
        /> */}


        <div class="vl"></div>
        
        </>
    );

};
export default ViewAllIssues;