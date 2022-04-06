# Sistema-de-Login
Sistema de Login usando server socket para estudos<br><br>

![SistemaDeLogin](https://user-images.githubusercontent.com/58037508/159175099-113c9221-14a2-4d2e-a80a-1f66b55e98f8.png)

<h2>Mandando mensagem para o ServerSocket</h2>

Ao digitar o login e senha e clicar em logar você enviara seu login e senha ao ServerSocket e fará uma requisição.

![Mensagem](https://i.imgur.com/BlJeUZ2.png)

<h2>Recebendo mensagem do cliente e enviando resposta</h2>

Após ser feita a requisição ao ServerSocket ele fará uma consulta e validação no banco de dados e enviara uma resposta ao cliente.

![Resposta](https://i.imgur.com/vJp3T4O.png)<br>

# Sistema de tentativas falhas
Após 3 tentativas falhas o socket envia mensagem para aplicação avisando que a mesma deve ser fechada para evitar Brute Force

![Resposta](https://i.imgur.com/zpggfun.png)<br>
