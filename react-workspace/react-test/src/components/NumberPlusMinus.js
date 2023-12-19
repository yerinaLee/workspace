import React, { useState } from 'react';


const NumberPlusMinus = (props)=>{
  
  const [count, setCount] = useState(props.init);

  return(
    <div>
      <span>
        <button className='minusBtn' onClick={()=>{ setCount(count-1) }}>-</button>
      </span>
      <sapn>
        {count}
      </sapn>
      <span>
        <button className="plusBtn" onClick={()=>{ setCount(count+1) }}>+</button>
      </span>
    </div>
  );

}  


export default NumberPlusMinus;