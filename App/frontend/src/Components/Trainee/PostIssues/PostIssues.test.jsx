import userEvent from '@testing-library/user-event';
import PostIssues from './PostIssues.jsx';
import { fireEvent, render } from '@testing-library/react';

describe('Posting Issues Testing',()=>{

    const mockSubmitFunction = jest.fn();
    const d_title = "Help!";
    const d_issue= "I can't get Project 3 working!";
    const d_topicTag= "React";
    const d_topic= "React";
    const d_priority = "1";
    const d_priorityTag = "High";
    const d_status = "Open";
    const d_traineeid = "1";

    it('should check if the title updates', () => {
        const {container} = render(<PostIssues/>);
        const titleInput = container.querySelector('[id="title"]');
        expect(titleInput.value).toEqual('');
    
        userEvent.type(titleInput,d_title);
    
        expect(titleInput.value).toEqual(d_title);
    });

    it('should check if the issue updates', () => {
        const {container} = render(<PostIssues/>);
        const issueInput = container.querySelector('[id="issue"]');
        expect(issueInput.value).toEqual('');
    
        userEvent.type(issueInput,d_issue);
    
        expect(issueInput.value).toEqual(d_issue);
    });
    
    it('should check if Topic updates', () => {
        const {container} = render(<PostIssues/>);
        const topicInput = container.querySelector('[id="topic"]');
        expect(topicInput.value).toEqual('');

        userEvent.selectOptions(topicInput, d_topicTag)
    
        expect(topicInput.value).toEqual(d_topic);
    });

    it('should check if Priority updates', () => {
        const {container} = render(<PostIssues/>);
        const priorityInput = container.querySelector('[id="priority"]');
        expect(priorityInput.value).toEqual('');

        userEvent.selectOptions(priorityInput, d_priorityTag)
    
        expect(priorityInput.value).toEqual(d_priority);
    });

    it('should call the handleSubmit function for posting issues', async () => {
        const {container} = render(<PostIssues onSubmit={mockSubmitFunction}/>);
        const titleInput = container.querySelector('[id="title"]');
        const issueInput = container.querySelector('[id="issue"]');
        const topicInput = container.querySelector('[id="topic"]');
        const priorityInput = container.querySelector('[id="priority"]');
        const issueSubmit = container.querySelector('[id="postButton"]');
        issueSubmit.onClick=mockSubmitFunction()
        
        userEvent.type(titleInput, d_title);
        userEvent.type(issueInput, d_issue);
        userEvent.selectOptions(topicInput, d_topicTag);
        userEvent.selectOptions(priorityInput, d_priorityTag);
        fireEvent.click(issueSubmit);
    
        expect(mockSubmitFunction).toHaveBeenCalled();
    
    });

    it(`should get a response for the database issues table`, () => {
        function getAllTest(){
            return new Promise(async(resolve, reject) => {
                
                const ip = useContext(IpContext);
                let response = await fetch("http://"+ip+"/ticket/getAll");
                let issues = response.json(); 

                for(let i=0; i<issues.length; i++){
                    console.log(issues[i].title);
                }
                if(issues !== null){
                    try{resolve("Data Recieved");
                    }
                    catch(error){reject("Missing Data");
                    }
                }

            }); 
        }
        expect(getAllTest()).resolves.toMatch("1");
    })



});