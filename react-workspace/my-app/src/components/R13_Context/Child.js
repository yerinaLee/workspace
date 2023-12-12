import React, { useContext, useState } from 'react';

/* 외부 Context 객체 import */
import UserContext from './UserContext';

/* 자식 컴포넌트 */
const Child = () => {

  /* Context를 통해 제공된 값을 얻어와 변수명과, key가 일치하는 변수에 대입 */
  const {userList, setUserList} = useContext(UserContext);

  /* 상태 변수 선언 */
  const [inputName, setInputName] = useState('');
  const [inputAge, setInputAge] = useState('');


  /* 추가 버튼 클릭 시 수행할 함수(이벤트 핸들러) */
  const addUser = () => {

    // 상태 변수에 저장된 값을 이용해 user 객체 생성
    const user = {name : inputName, age : inputAge};

    // Context를 통해 제공 받은 userList 깊은 복사 + user 객체를 추가한 새로운 배열 생성
    const newUserList = [ ...userList, user];

    // Context를 통해 제공 받은 setUserList()를 이용해 부모의 상태 변수 값을 수정
    setUserList(newUserList);

    // 현재 컴포넌트의 상태 변수를 빈칸으로 수정(내용 지우기)
    setInputName('');
    setInputAge('');
  }


  return(
    <div>
      <label>이름 : </label>
      <input type='text' onChange={ e => setInputName(e.target.value)} value={inputName}/>

      <br/>
      
      <label>나이 : </label>
      <input type='number' onChange={ e => setInputAge(e.target.value)} value={inputAge}/>

      <button onClick={addUser}>추가</button>
    </div>
  );
}


export default Child;