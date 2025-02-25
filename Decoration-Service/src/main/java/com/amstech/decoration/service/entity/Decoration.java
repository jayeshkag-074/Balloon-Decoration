package com.amstech.decoration.service.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the decorations database table.
 * 
 */
@Entity
@Table(name="decorations")
@NamedQuery(name="Decoration.findAll", query="SELECT d FROM Decoration d")
public class Decoration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_at")
	private Date createAt;

	@Column(name="decorater_id")
	private int decoraterId;

	@Lob
	private String description;

	@Column(name="image_url")
	private String imageUrl;

	private String name;

	private double price;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="decoration")
	private List<Booking> bookings;

	//bi-directional many-to-one association to Colour
	@ManyToOne
	private Colour colour;

	//bi-directional many-to-one association to DecorationBanner
	@ManyToOne
	@JoinColumn(name="decoration_banner_id")
	private DecorationBanner decorationBanner;

	//bi-directional many-to-one association to Design
	@ManyToOne
	private Design design;

	//bi-directional many-to-one association to Event
	@ManyToOne
	private Event event;

	//bi-directional many-to-one association to Location
	@ManyToOne
	private Location location;

	//bi-directional many-to-one association to Material
	@ManyToOne
	private Material material;

	//bi-directional many-to-one association to Size
	@ManyToOne
	private Size size;

	//bi-directional many-to-one association to Status
	@ManyToOne
	private Status status;

	//bi-directional many-to-one association to Type
	@ManyToOne
	private Type type;

	//bi-directional many-to-one association to Feedback
	@OneToMany(mappedBy="decoration")
	private List<Feedback> feedbacks;

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="decoration")
	private List<Notification> notifications;

	public Decoration() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateAt() {
		return this.createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public int getDecoraterId() {
		return this.decoraterId;
	}

	public void setDecoraterId(int decoraterId) {
		this.decoraterId = decoraterId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Booking> getBookings() {
		return this.bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Booking addBooking(Booking booking) {
		getBookings().add(booking);
		booking.setDecoration(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setDecoration(null);

		return booking;
	}

	public Colour getColour() {
		return this.colour;
	}

	public void setColour(Colour colour) {
		this.colour = colour;
	}

	public DecorationBanner getDecorationBanner() {
		return this.decorationBanner;
	}

	public void setDecorationBanner(DecorationBanner decorationBanner) {
		this.decorationBanner = decorationBanner;
	}

	public Design getDesign() {
		return this.design;
	}

	public void setDesign(Design design) {
		this.design = design;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Size getSize() {
		return this.size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Feedback addFeedback(Feedback feedback) {
		getFeedbacks().add(feedback);
		feedback.setDecoration(this);

		return feedback;
	}

	public Feedback removeFeedback(Feedback feedback) {
		getFeedbacks().remove(feedback);
		feedback.setDecoration(null);

		return feedback;
	}

	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Notification addNotification(Notification notification) {
		getNotifications().add(notification);
		notification.setDecoration(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setDecoration(null);

		return notification;
	}

}