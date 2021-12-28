import './App.css';
import Header from './customs/Header';
import Footer from './customs/Footer';
import LoginPage from './Signup/LoginPage';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
    <div className="App">
      <Header></Header>
      <LoginPage></LoginPage>
      <Footer></Footer>
    </div>
  );
}

export default App;
