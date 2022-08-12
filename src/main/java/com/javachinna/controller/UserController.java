package com.javachinna.controller;
import com.javachinna.model.DatabaseFile;
import com.javachinna.model.User;
import com.javachinna.payLoad.Response;
import com.javachinna.service.DatabaseFileService;
import com.javachinna.service.UserService;
import com.javachinna.service.exportPdf;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.javachinna.config.CurrentUser;
import com.javachinna.dto.LocalUser;
import com.javachinna.util.GeneralUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin()
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private DatabaseFileService fileStorageService;
	@Autowired
	exportPdf exportPdfservice;


	@ApiOperation(value = " Search Historique ")
	@PostMapping("/SearchHistorique/{keyword}")
	@ResponseBody
	public void SearchHistorique(@PathVariable("keyword") String keyword)
	{
		userService.SearchHistorique(keyword);
	}

	@ApiOperation(value = " Search User Multiple  ")
	@GetMapping("/SearchMultiple/{keyword}")
	@ResponseBody
	public List<User> SearchComplaintMultiple(@PathVariable("keyword")  String key){
		return  userService.searchmultilplUser(key);

	}


	@GetMapping(value = "/ListeUserpdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> exportTermsPDF(){
		List<User> userList = userService.retrieveAllUsers ();
		ByteArrayInputStream bais = exportPdfservice.UserPDFReport (userList);
		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-Disposition", "attachment;filename=ListeDesUtilisateurs.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bais));
	}


	@PostMapping("/uploadFile/{idU}")
	@ResponseBody
	public Response uploadFile(@RequestParam("file") MultipartFile file, @PathVariable(name = "idU") Long id) {
		DatabaseFile fileName = fileStorageService.storeFile(file,id);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/downloadFile/")
				.path(fileName.getFileName())
				.toUriString();

		return new Response(fileName.getFileName(), fileDownloadUri,
				file.getContentType(), file.getSize());
	}


	@PostMapping("/uploadMultipleFiles/{idU}")
	public List<Response> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files,@PathVariable(name = "idU") Long id) {
		return Arrays.asList(files)
				.stream()
				.map(file -> uploadFile(file,id))
				.collect(Collectors.toList());
	}

	@GetMapping("/downloadFile/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) throws FileNotFoundException {
		// Load file as Resource
		DatabaseFile databaseFile = fileStorageService.getFile(fileName);

		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(databaseFile.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + databaseFile.getFileName() + "\"")
				.body(new ByteArrayResource(databaseFile.getData()));
	}

	@PostMapping("/addUser")
	@ResponseBody
	@ApiOperation(value = "Add User")
	public void addPartner (@RequestBody User user) {
		userService.addUser(user);
	}




	@ApiOperation(value = "retrieve All Users ")
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/retrieve-All-Users")
	@ResponseBody
	public List<User> RetrieveAllUsers()
	{
		return  userService.retrieveAllUsers();
	}

	@ApiOperation(value = "update User By Id ")
	@PutMapping("/updateUserById/{idU}")
	@ResponseBody
	public void UpdateUser(@RequestBody User u, @PathVariable(name="idU") Long idUser)
	{
		userService.updateUser(u,idUser);
	}

	@ApiOperation(value = "delete User By Id ")
	@GetMapping("/deleteUserById/{idU}")
	@ResponseBody
	public void DeleteUser(@PathVariable("idU") Long idU)
	{
		userService.deleteUser(idU);

	}
	@ApiOperation(value = "Retrieve User by ID ")
	@GetMapping("/retrieve-User-by-ID/{idU}")
	@ResponseBody
	public User RetrieveUser(@PathVariable("idU") Long idU)
	{
		return userService.retrieveUser(idU);
	}


	@GetMapping("/user/me")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getCurrentUser(@CurrentUser LocalUser user) {
		return ResponseEntity.ok(GeneralUtils.buildUserInfo(user));
	}

	@GetMapping("/all")
	public ResponseEntity<?> getContent() {
		return ResponseEntity.ok("Public content goes here");
	}

	@GetMapping("/user")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getUserContent() {
		return ResponseEntity.ok("User content goes here");
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAdminContent() {
		return ResponseEntity.ok("Admin content goes here");
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public ResponseEntity<?> getModeratorContent() {
		return ResponseEntity.ok("Moderator content goes here");
	}
}