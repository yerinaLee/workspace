import React, { useState } from 'react';

/* 외부 Context 객체 import */
import UserContext from './UserContext';

/* 외부 Child 컴포넌트 import */
import Child from './Child';

/* 부모 컴포넌트 */
const Parent = () => {

  /* 상태 변수 userList */
  const [userList, setUserList] = useState([]);

  return (
    /* 하위 컴포넌트에 Context를 이용해서 userList, setUserList 제공 */
    <UserContext.Provider value={{ userList, setUserList }}>

      <Child />

      {/* 상태 변수 userList에 저장된 값을 화면에 출력 */}
      <div>

        {/* key 속성 : 배열(list) 출력 시 요소를 구분하는 key값 */}
        {userList.map((user, index) => {
          return (
            <ul key={index}>
              <li>index : {index}</li>
              <li>name : {user.name}</li>
              <li>age : {user.age}</li>
            </ul>
          );
        })}
      </div>
    </UserContext.Provider>
  );
}

export default Parent;

/* ctrl + shift + f : 자동 들여쓰기 */