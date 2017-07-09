drop procedure if exists querycart;
delimiter $
create procedure querycart(
	in in_itemid varchar(10),
	in in_quantity int(11)
)
begin
	set @a:="";
	set @date0:="";
	set @item_id="";
	select orderid,orderdate into @a,@date0 from orders order by orderid desc limit 1;
	if  @orderdate!="" then
		set @a:=@a+1;
		insert into orders(orderid) values (@a);
		insert into cart(orderid,itemid,quantity) values(@a,in_itemid,in_quantity);
		else
			select itemid into @item_id from cart where itemid=in_itemid and orderid=@a;
			if @item_id!="" then
				update cart set quantity=quantity+in_quantity where orderid=@a;
			else
				insert into cart(orderid,itemid,quantity) values (@a,in_itemid,in_quantity);
			end if;
	end if;
	select * from cart where orderid=@a;
end $
delimiter ;