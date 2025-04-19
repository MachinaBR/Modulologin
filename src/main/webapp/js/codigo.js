document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form"); 
    const usernameInput = document.getElementById("username"); 
    const passwordInput = document.getElementById("password"); 
    const rememberCheckbox = document.getElementById("remember"); 
    const captchaCheckbox = document.getElementById("captcha"); 

    
    form.addEventListener("submit", function (event) {
        event.preventDefault(); 

        let username = usernameInput.value.trim();
        let password = passwordInput.value.trim();

        
        if (username === "" || password === "") {
            alert("❌ Por favor, completa todos los campos.");
            return;
        }

        if (!captchaCheckbox.checked) {
            alert("⚠️ Debes marcar la casilla 'No soy un robot'.");
            return;
        }

        
        if (rememberCheckbox.checked) {
            localStorage.setItem("username", username);
            localStorage.setItem("password", password);
        } else {
            localStorage.removeItem("username");
            localStorage.removeItem("password");
        }

        
        const usuarioCorrecto = "admin";
        const contraseñaCorrecta = "1234";

        if (username === usuarioCorrecto && password === contraseñaCorrecta) {
            alert("✅ Inicio de sesión exitoso");
            window.location.href = "dashboard.html"; 
        } else {
            alert("🚫 Usuario o contraseña incorrectos.");
        }
    });

    
    if (localStorage.getItem("username") && localStorage.getItem("password")) {
        usernameInput.value = localStorage.getItem("username");
        passwordInput.value = localStorage.getItem("password");
        rememberCheckbox.checked = true;
    }


    const togglePassword = document.createElement("span");
    togglePassword.classList.add("toggle-password");
    togglePassword.style.width = "24px";
    togglePassword.style.height = "24px";
    togglePassword.style.position = "absolute";
    togglePassword.style.right = "10px";
    togglePassword.style.top = "50%";
    togglePassword.style.transform = "translateY(-50%)";
    togglePassword.style.backgroundRepeat = "no-repeat";
    togglePassword.style.backgroundSize = "contain";
    togglePassword.style.backgroundImage = "url('imagenes/eye.png')"; // 👈 SE VE DESDE EL INICIO
    togglePassword.style.filter = "brightness(0.3) contrast(150%)";
    togglePassword.style.cursor = "pointer";


    document.querySelector(".input-group1").appendChild(togglePassword);;

    togglePassword.addEventListener("click", function () {
        if (passwordInput.type === "password") {
            passwordInput.type = "text";
            togglePassword.style.backgroundImage = "url('imagenes/eye.png')";
            togglePassword.style.filter = "brightness(0.3) contrast(150%)"
        } else {
            passwordInput.type = "password";
            togglePassword.style.backgroundImage = "url('imagenes/eye-off.png')";
            togglePassword.style.filter = "brightness(0.3) contrast(150%)"
        }
    });
});