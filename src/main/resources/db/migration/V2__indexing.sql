
CREATE INDEX ix_crop_alternate_name ON public.crop USING btree (alternate_name);

CREATE INDEX ix_crop_crop_type_id ON public.crop USING btree (crop_type_id);

CREATE INDEX ix_crop_hash_id ON public.crop USING btree (hash_id);

CREATE INDEX ix_crop_hindi_name ON public.crop USING btree (hindi_name);

CREATE INDEX ix_crop_name ON public.crop USING btree (name);

CREATE INDEX ix_crop_reaping_end_time ON public.crop USING btree (reaping_end_time);

CREATE INDEX ix_crop_reaping_start_time ON public.crop USING btree (reaping_start_time);

CREATE INDEX ix_crop_season ON public.crop USING btree (season);

CREATE INDEX ix_crop_sowing_end_time ON public.crop USING btree (sowing_end_time);

CREATE INDEX ix_crop_sowing_start_time ON public.crop USING btree (sowing_start_time);

CREATE INDEX ix_crop_url_str ON public.crop USING btree (url_str);

CREATE INDEX ix_crop_is_deleted ON public.crop USING btree (is_deleted);


