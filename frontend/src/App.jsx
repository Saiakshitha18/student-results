import { useEffect, useState } from "react";
import "./App.css";

function App() {

  const [students, setStudents] = useState([]);

  useEffect(() => {

    fetch("http://localhost:8080/api/students")
        .then((response) => response.json())
        .then((data) => {
          console.log(data);
          setStudents(data);
        })
        .catch((error) => {
          console.error("Error fetching students:", error);
        });

  }, []);

  return (
      <div className="container">

        <h1>Student Results</h1>

        <table>

          <thead>
          <tr>
            <th>ID</th>
            <th>Roll Number</th>
            <th>Student Name</th>
            <th>Class</th>
            <th>Maths</th>
            <th>Physics</th>
            <th>Chemistry</th>
            <th>English</th>
            <th>Computer Science</th>
            <th>Total</th>
            <th>Percentage</th>
            <th>Result</th>
          </tr>
          </thead>

          <tbody>

          {students.map((student) => (

              <tr key={student.id}>

                <td>{student.id}</td>

                <td>{student.rollNumber}</td>

                <td>{student.studentName}</td>

                <td>{student.className}</td>

                <td>{student.maths}</td>

                <td>{student.physics}</td>

                <td>{student.chemistry}</td>

                <td>{student.english}</td>

                <td>{student.computerScience}</td>

                <td>{student.totalMarks}</td>

                <td>{student.percentage}%</td>

                <td>{student.result}</td>

              </tr>

          ))}

          </tbody>

        </table>

      </div>
  );
}

export default App;