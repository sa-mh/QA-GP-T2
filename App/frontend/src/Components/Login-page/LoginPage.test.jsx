import userEvent from '@testing-library/user-event';
import LoginForm from './LoginPage.jsx';
import { fireEvent, render } from '@testing-library/react';

describe('Form Testing',()=>{

const mockSubmitFunction = jest.fn();
const d_Username= "JDoe";
const d_Password= "QA-TEST-P4SS";
const d_Trainee = "Trainee";
const d_Trainer = "Trainer";

it('should check if the username updates', () => {
    const {container} = render(<LoginForm submit={mockSubmitFunction}/>);
    const usernameInput = container.querySelector('[name="username"]');
    expect(usernameInput.value).toEqual('');

    userEvent.type(usernameInput,d_Username);

    expect(usernameInput.value).toEqual(d_Username);
});


it('should check if password updates', () => {
    const {container} = render(<LoginForm submit={mockSubmitFunction}/>);
    const passwordInput = container.querySelector('[name="password"]');
    expect(passwordInput.value).toEqual('');

    userEvent.type(passwordInput,d_Password);

    expect(passwordInput.value).toEqual(d_Password);
});

it('should check if MemberSelector updates', () => {
    const {container} = render(<LoginForm submit={mockSubmitFunction}/>);
    const memberVar = container.querySelector('[name="traineeTrainer"]');
    expect(memberVar.value).toEqual('');

    userEvent.type(memberVar,d_Trainee);

    expect(memberVar.value).toNotEqual(d_Trainer);

    userEvent.type(memberVar,d_Trainer);

    expect(memberVar.value).toEqual(d_Trainer);

});

it('should call the handleSubmit function', () => {
    const {container} = render(<LoginForm submit={mockSubmitFunction}/>);
    const passwordInput = container.querySelector('[name="username"]');
    const usernameInput = container.querySelector('[name="email"]');
    const trainerTrainee = container.querySelector('[name="traineeTrainer"]');
    const submitButton = container.querySelector('[type="submit"]');
    
    userEvent.type(passwordInput, d_Password);
    userEvent.type(usernameInput,d_Username);
    userEvent.selectOptions(trainerTrainee,d_Trainee);
    fireEvent.click(submitButton);

    expect(mockSubmitFunction).toHaveBeenCalled();
    expect(mockSubmitFunction).toHaveBeenCalledWith({username : d_Username, password : d_Password, memberType : d_Trainee});

});

});