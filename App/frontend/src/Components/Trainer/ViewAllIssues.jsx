import React, { useState } from 'react'
import axios from 'axios'

const ViewAllIssues = () => {

    const [data, setData] = useState("");


    // making a get request which pulls the issues from the database - NOT SURE IF THIS WORKS. please Fix!
    axios.get("http://localhost:8080/")
        .then(response => {
            console.log(response.data);
            setData(response.data);
        });

    return (
        <div>

            
        </div>
    )

}
export default ViewAllIssues;