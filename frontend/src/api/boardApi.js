export const getAllBoards = async () => {
    const response = await fetch("http://localhost:8081/api/boards");
    if(!response.ok) throw new Error(`HTTP error! Status : ${response.status}`);
    return await response.json();
};

export const createBoard = async (data) => {
    const response = await fetch("http://localhost:8081/api/boards",{
        method:"POST",
        headers: {"Content-type":"application/json"},
        body: JSON.stringify(data),
    });
    if(!response.ok) throw new Error(`HTTP error! Status : ${response.status}`);
    return await response.json();
}