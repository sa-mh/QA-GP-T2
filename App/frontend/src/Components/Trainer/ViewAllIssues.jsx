import React, { useState } from 'react'
import axios from 'axios'
import Issue from './Issue';


const ViewAllIssues = () => {

    const [data, setData] = useState("");


    // making a get request which pulls the issues from the database - NOT SURE IF THIS WORKS. please Fix!
    axios.get("/trainer/getAll")
        .then(response => {
            console.log(response.data);
            setData(response.data);
        });


    //The data saved from the API call should be then used to display it on the page. Right now I have just hard coded some text in there to see how the page would look. 
    return (
        <>
        <h1> View all the Issues here</h1>

        <Issue 
        title={"The title of the issue appears here"} 
        message={"Get Axios to pull and display data"}
        topic={"Chosen topic"}
        date={"01/02/03"}
        priority={"High"}
        />


        <div class="vl"></div>
        
        </>
    );

};
export default ViewAllIssues;

// {/* {data.map((issue) => (
//             <Issue title={issue.title} message={issue.message}/>
//         ))} */}