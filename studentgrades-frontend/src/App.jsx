import { useEffect, useState } from 'react';
import axios from 'axios';

function App() {
  const [students, setStudents] = useState([]);
  const [form, setForm] = useState({
    name: '',
    course: '',
    marks: '',
    date: ''
  });

  // Fetch all students on mount
  useEffect(() => {
    axios.get('http://localhost:8080/students')
      .then(res => setStudents(res.data))
      .catch(err => console.error('Error fetching students:', err));
  }, []);

  // Handle input changes
  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm(prev => ({ ...prev, [name]: value }));
  };

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post('http://localhost:8080/students', form)
      .then(res => {
        setStudents(prev => [...prev, res.data]);
        setForm({ name: '', course: '', marks: '', date: '' }); // reset form
      })
      .catch(err => console.error('Error adding student:', err));
  };

  return (
    <div style={{ padding: '20px' }}>
      <h1>Student List</h1>

      <ul>
        {students.map((student, index) => (
          <li key={index}>
            {student.name} - {student.course} - {student.marks} marks - {student.date}
          </li>
        ))}
      </ul>

      <h2>Add Student</h2>
      <form onSubmit={handleSubmit}>
        <input name="name" placeholder="Name" value={form.name} onChange={handleChange} required />
        <input name="course" placeholder="Course" value={form.course} onChange={handleChange} required />
        <input name="marks" placeholder="Marks" type="number" value={form.marks} onChange={handleChange} required />
        <input name="date" placeholder="Date" type="date" value={form.date} onChange={handleChange} required />
        <button type="submit">Add</button>
      </form>
    </div>
  );
}

export default App;
