document.addEventListener('DOMContentLoaded', () => {
    
    // --- LÓGICA DE LOGIN ---
    const btnLogin = document.getElementById('btn-login');
    if (btnLogin) {
        btnLogin.addEventListener('click', (e) => {
            e.preventDefault();
            
            const email = document.getElementById('email-login').value;
            const senha = document.getElementById('senha-login').value;

            if (!email || !senha) {
                alert("Preencha todos os campos!");
                return;
            }

            fetch('http://localhost:8080/api/auth/login', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ email: email, senha: senha })
            })
            .then(res => {
                if (res.ok) return res.json();
                throw new Error("E-mail ou senha incorretos!");
            })
            .then(usuario => {
                localStorage.setItem('usuarioLogado', JSON.stringify(usuario));
                alert(`Bem-vindo, ${usuario.nomeUsuario}!`);
                window.location.href = "principal.html";
            })
            .catch(err => alert(err.message));
        });
    }

    // --- LÓGICA DE CADASTRO ---
    const btnCadastrar = document.getElementById('btn-cadastrar');
    if (btnCadastrar) {
        btnCadastrar.addEventListener('click', (e) => {
            e.preventDefault();

            const nome = document.getElementById('nome-cadastro').value;
            const email = document.getElementById('email-cadastro').value;
            const senha = document.getElementById('senha-cadastro').value;
            const confirma = document.getElementById('confirmar-senha').value;

            if (senha !== confirma) {
                alert("As senhas não conferem!");
                return;
            }

            fetch('http://localhost:8080/api/auth/cadastro', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({
                    nomeUsuario: nome,
                    emailUsuario: email,
                    senhaUsuario: senha
                })
            })
            .then(res => {
                if (res.ok) {
                    alert("Cadastro realizado! Agora faça login.");
                    window.location.href = "index.html";
                } else {
                    throw new Error("Erro no cadastro. Verifique se o e-mail já existe.");
                }
            })
            .catch(err => alert(err.message));
        });
    }
});