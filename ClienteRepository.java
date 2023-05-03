package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Cliente;
import factories.ConnectionFactory;

public class ClienteRepository {

	// método para inserir um cliente no banco de dados
	public void create(Cliente cliente) throws Exception {

		// abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();

		// escrevendo uma instrução SQL para inserir um cliente na base de dados
		PreparedStatement statement = connection
				.prepareStatement("insert into tb_cliente(nome, email, cpf, telefone) values(?, ?, ?, ?)");
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getCpf());
		statement.setString(4, cliente.getTelefone());
		statement.execute();

		// fechando a conexão
		connection.close();
	}

	// método para atualizar um cliente no banco de dados
	public void update(Cliente cliente) throws Exception {

		// abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();

		// escrevendo uma instrução SQL para atualizar um cliente na base de dados
		PreparedStatement statement = connection
				.prepareStatement("update tb_cliente set nome=?, email=?, cpf=?, telefone=? where idcliente=?");
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getCpf());
		statement.setString(4, cliente.getTelefone());
		statement.setInt(5, cliente.getIdCliente());
		statement.execute();

		// fechando a conexão
		connection.close();
	}

	// método para excluir um cliente no banco de dados
	public void delete(Cliente cliente) throws Exception {

		// abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();

		// escrevendo uma instrução SQL para excluir um cliente na base de dados
		PreparedStatement statement = connection.prepareStatement("delete from tb_cliente where idcliente=?");
		statement.setInt(1, cliente.getIdCliente());
		statement.execute();

		// fechando a conexão

		connection.close();
	}

}

	public List<Cliente> findAll() throws Exception{
		//abrinco conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		
		//escrevendo uma instrução AQL para consultar todos os clientes cadastrados
		PreparedStatement statement = connection.prepareStatement("select * from tb_cliente");
		ResultSet resultSet = statement.executeQuery();
		List<Cliente> lista = new ArrayList<Cliente>();
		
		//lendo cada registro contido no ResultSet
		while (resultSet.next()) {
			
			Cliente cliente = new Cliente();
			
			cliente.setIdCLiente(resultSet.getInt("idcliente"));
			cliente.setNome(resultSet.getString("nome"));
			cliente.setEmail(resultSet.getString("email"));
			cliente.setTelefone(resultSet.getString("telefone"));
			cliente.setCpf(resultSet.getString("cpf"));
			
			lista.add(cliente); //armazenando cada cliente dentro de uma lista
			
		}
		connection.close();
		return lista;
	}

	public Cliente findById(Integer idCliente) throws Exception() {
		Connection connection = ConnectionFactory.getConnection();
		
		//escrevendo uma instrução SQL pára coinsultar cliente através do id
		PreparedStatement statement = connection.prepareStatement("select * from tb_cliente where idcliente?");
		statement.setInt(1, idCliente);
		ResultSet resultSet = statement.executeQuery();
		
		Cliente cliente = null;
		 if(resultSet.next()) {
			 
			 cliente = new Cliente();
			 
			 cliente.setIdCliente(resultSet.getInt("idcliente"));
			 cliente.setNome(resultSet.getString("nome"));
			 cliente.setCpf(resultSet.getString("cpf"));
			 cliente.setEmail(resultSet.getString("email"));
			 cliente.setTelefone(resultSet.getString("telefone"));
		 }
		 
		 connection.close();
		 return cliente;
	}	 
}