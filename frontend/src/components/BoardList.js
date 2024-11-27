import React,{useEffect,useState} from "react";
import { getAllBoards } from "../api/boardApi";

const BoardList = () => {
    const[boards,setBoards] = useState([]);

    useEffect(()=>{
        getAllBoards()
        .then(setBoards)
        .catch((error) => console.error(error));
    },[]);

    return(
        <div>
            <h1>게시판 목록</h1>
            <ul>
                {boards.map((board)=>(
                    <li key={board.id}>
                        {board.title} (작성자 : {board.author})
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default BoardList;